package com.github.jclb.globalsolution.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.jclb.globalsolution.dto.FormPeixe;
import com.github.jclb.globalsolution.lov.ListOfValueBuilder;
import com.github.jclb.globalsolution.model.Peixe;
import com.github.jclb.globalsolution.repository.PeixeRepository;

@Controller()
@RequestMapping()
public class PeixesController {
	
	@Autowired
	private PeixeRepository repository;
	@Autowired
	private ListOfValueBuilder listOfValueBuilder;
	
	@GetMapping()
	public String list(Model model) {
		List<Peixe> peixes = repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("peixe", peixes);
		return "peixe/lista";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("peixe", new FormPeixe());
		return "peixe/form";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute FormPeixe peixe) {
		repository.save(peixe.toModel());
		return "redirect:/";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Peixe peixe =repository.findById(id).orElse(new Peixe());

		model.addAttribute("peixe", new FormPeixe().toForm(peixe));
		return "peixe/form";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
	}

