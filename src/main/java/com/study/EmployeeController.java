package com.study;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @Autowiredを使用しない書き方
@Controller
public class EmployeeController {

	private final EmployeeRepository repository;

	@GetMapping("/")
	public String showList(Model model) {
		//JPAでEmployeeのデータを全て取得
		model.addAttribute("emp", repository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		//社員登録遷移
		return "form";
	}

	@PostMapping("/process1")
	public String process1(@Validated @ModelAttribute Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		//社員登録
		repository.save(employee);
		return "redirect:/";
	}

	@GetMapping("/edit")
	public String editEmployee(Model model, @RequestParam("id") Long id) {
		//編集画面遷移
		Optional<Employee> optionalEmployee = repository.findById(id);
		//java.util.Optionalは「nullかもしれない値」を上手に取り扱うためのクラス
		//値をラップし、その値がnullかもしれないことを表現する
		Employee employee = optionalEmployee.get();
		model.addAttribute("employee", employee);
		return "edit";
	}

	@PostMapping("/process2")
	public String process2(@Validated @ModelAttribute Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		}
		//編集
		repository.save(employee);
		return "redirect:/";
	}

	@GetMapping("/del")
	public String process3(@RequestParam("id") Long id) {
		//削除
		repository.deleteById(id);
		return "redirect:/";
	}

}