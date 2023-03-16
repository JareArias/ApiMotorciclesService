package com.motos.moto01.mapper;

public interface IMapper <I, O>{
    public O map(I in);
    public void update(I in, O out);
}