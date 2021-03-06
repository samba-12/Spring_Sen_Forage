package com.senforage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.senforage.entities.Clients;
import com.senforage.entities.Villages;
import com.senforage.dao.IClients;
import com.senforage.dao.IVillages;

@Controller
public class ClientsController {
	
	
	@Autowired
	private IVillages villagedao;
	@Autowired
	private IClients clientsdao;
	
	@RequestMapping(value = "Clients/liste")
	public ModelAndView liste() {
		 List<Clients> clients = clientsdao.findAll();
		return new ModelAndView("clients/liste", "liste_clients", clients);
			}
	
	@RequestMapping(value = "Clients/addclient", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView addclient(Integer idClient, String prenom, String nom, String adresse, String telephone, Integer idVillage) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Clients clients = new Clients();
		clients.setIdClient(idClient);
		clients.setPrenom(prenom);
		clients.setNom(nom);
		clients.setAdresse(adresse);
		clients.setTelephone(telephone);
		Villages village = new Villages();
		village = villagedao.getOne(idVillage);
		clients.setVillage(village);
		
		try {
		clientsdao.save(clients);
		
			modelAndView.addObject("result", new String("Clients Ajoute"));
		
		}catch(Exception ex)
		{
			modelAndView.addObject("result", new String("Ajout echec"));		
		}
			modelAndView.addObject(new String("clients/liste"));

			return   modelAndView;

		
	}


}
