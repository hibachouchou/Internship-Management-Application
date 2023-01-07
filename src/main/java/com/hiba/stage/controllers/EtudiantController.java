package com.hiba.stage.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hiba.stage.entities.Etudiant;
import com.hiba.stage.service.EtudiantService;



@Controller
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;
	@RequestMapping("/showCreateE")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("etudiant", new Etudiant());
	modelMap.addAttribute("mode", "newe");
	return "formEtudiant";
	}

	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@Valid Etudiant etudiant,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formEtudiant";
	 
	etudiantService.saveEtudiant(etudiant);
	return "redirect:/ListeEtudiants";
	}
	
	
	@RequestMapping("/ListeEtudiants")
	public String listeEtudiants(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)
	{
	Page<Etudiant> Etud = etudiantService.getAllEtudiantsParPage(page, size);
	modelMap.addAttribute("etudiant", Etud);
	 modelMap.addAttribute("pages", new int[Etud.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeEtudiants";
	}
	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)
	{
	etudiantService.deleteEtudiant(id);
	Page<Etudiant> Etud  = etudiantService.getAllEtudiantsParPage(page, 
	size);
	modelMap.addAttribute("etudiant", Etud);
	modelMap.addAttribute("pages", new int[Etud.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeEtudiants";
	}


	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Etudiant e= etudiantService.getEtudiant(id);
	modelMap.addAttribute("etudiant", e);
	modelMap.addAttribute("mode", "edit");
	return "formEtudiant";
	}
}
	
	
