package com.hiba.stage.controllers;

import java.text.ParseException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hiba.stage.entities.Etudiant;
import com.hiba.stage.entities.Stage;
import com.hiba.stage.service.EtudiantService;
import com.hiba.stage.service.StageService;


@Controller
public class StageController {

	@Autowired
	StageService stageService;
	@Autowired
	EtudiantService etudiantService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{   
		  Etudiant etud = new Etudiant();
		  List<Etudiant> etuds = etudiantService.getAllEtudiants();
	    Stage stage = new Stage();
	    etud= etuds.get(0); // prendre la première catégorie de la liste
	    stage.setEtudiant(etud); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
   modelMap.addAttribute("etudiants", etuds);
	    modelMap.addAttribute("stage",stage);
	    modelMap.addAttribute("mode", "new");
	 
	    return "formStage";
	}
	@RequestMapping("/saveStage")
	public String saveStage(@Valid Stage stage,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formStage";
	 
	stageService.saveStage(stage);
	return "redirect:/ListeStages";
	}
	
	@RequestMapping("/ListeStages")
	public String listeStages(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)
	{
	Page<Stage> stage = stageService.getAllStagesParPage(page, size);
	modelMap.addAttribute("stage", stage);
	 modelMap.addAttribute("pages", new int[stage.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeStages";
	}
	@RequestMapping("/search")
	public String listeStagesParEtud(ModelMap modelMap, @Param("keyword") String keyword)
	{
	List<Stage> stage = stageService.findBynomEtudiant(keyword);
	modelMap.addAttribute("stage", stage);
	modelMap.addAttribute("keyword", keyword);
	return "listeSearch";
	}
	@RequestMapping("/search2")
	public String listeStagesParType(ModelMap modelMap, @Param("keyword") String keyword)
	{
	List<Stage> stage = stageService.findByTypeStage(keyword);
	modelMap.addAttribute("stage", stage);
	modelMap.addAttribute("keyword", keyword);
	return "listeSearch2";
	}

	
	
	
	@RequestMapping("/supprimerStage")
	public String supprimerStage(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)
	{
	stageService.deleteStageById(id);
	Page<Stage> s = stageService.getAllStagesParPage(page, 
	size);
	modelMap.addAttribute("stage", s);
	modelMap.addAttribute("pages", new int[s.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeStages";
	}




	@RequestMapping("/modifierStage")
			public String editerStage(@RequestParam("id") Long id, ModelMap modelMap) {
		Stage s = stageService.getStage(id);
			
				modelMap.addAttribute("stage", s);
				modelMap.addAttribute("mode", "edit");
				return "formStage";
			}

	@RequestMapping("/updateStage")
	public String updateStage(@ModelAttribute("produit") Stage stage,
	ModelMap modelMap) throws ParseException 
	{


	stageService.updateStage(stage);
	List<Stage> s = stageService.getAllStages();
	modelMap.addAttribute("stage", s);
	return "redirect:/ListeStages";
	}


}
