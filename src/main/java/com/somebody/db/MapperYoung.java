package com.somebody.db;

import beans.Centers;

public interface MapperYoung {
	public int is(Centers ct);
	public List<Equipments> goodsList(Equipments eq);
	public List<Equipments> searchGoods(Equipments eq);
}
