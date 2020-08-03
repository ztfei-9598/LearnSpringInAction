package com.tacocloud.data;

import com.tacocloud.entity.Taco;

public interface TacoRepository
{
    Taco save(Taco design);
}