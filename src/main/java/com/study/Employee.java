package com.study;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キーを自動生成する
	private Long id;

	@NotBlank //null, ""(空文字), 全て半角スペース, タブ(\t) → ×(NotNullと似たアノテーション)
	@Size(max = 40)
	private String name;

	private String departmentName;
}
