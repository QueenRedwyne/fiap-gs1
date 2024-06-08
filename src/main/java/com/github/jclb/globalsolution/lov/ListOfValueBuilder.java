package com.github.jclb.globalsolution.lov;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.github.jclb.globalsolution.repository.PeixeRepository;



@Component
public class ListOfValueBuilder {

    @Autowired
    private PeixeRepository repository;

   

    public List<ListOfValues> getListOfPeixes() {
        List<ListOfValues> lov = repository.findAll(Sort.by(Sort.Direction.ASC, "nome"))
            .stream()
            .map(item -> new ListOfValues(item.getId(), item.getNome()))
            .toList();
        return lov;
    }}
