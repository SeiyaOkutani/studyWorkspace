package com.study;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //finalがある項目でコンストラクタを生成
@Component
public class DepartmentSet implements ApplicationRunner { // ApplicationRunnerはSpring起動時の最後の処理として実行される

	private final DepartmentRepository repository;

	@Override //そのメソッドがスーパークラスのメソッドをオーバーライド（上書き）していることを宣言
	public void run(ApplicationArguments args) throws Exception {
		var obj = new Department();
		obj.setName("営業");
		repository.save(obj);

		obj = new Department();
		obj.setName("開発");
		repository.save(obj);

		obj = new Department();
		obj.setName("人事");
		repository.save(obj);

		obj = new Department();
		obj.setName("経理");
		repository.save(obj);

		List<Department> list = repository.findAll();
		list.forEach(a -> System.out.println(a.getId() + "," + a.getName()));
	}
}