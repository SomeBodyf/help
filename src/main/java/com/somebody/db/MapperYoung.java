package com.somebody.db;

import java.util.List;

import beans.Centers;
import beans.Equipments;

public interface MapperYoung {
	public int is(Centers ct);
	public List<Equipments> goodsList(Equipments eq);
	public List<Equipments> searchGoods(Equipments eq);
}
