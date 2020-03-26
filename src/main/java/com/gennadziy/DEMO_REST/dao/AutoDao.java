package com.gennadziy.DEMO_REST.dao;

import com.gennadziy.DEMO_REST.model.Autoss;
import org.springframework.data.jpa.repository.JpaRepository;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: AutoDao
Date: 2020-03-22
Time: 17:22
*/
public interface AutoDao extends JpaRepository<Autoss, Integer> {
}
