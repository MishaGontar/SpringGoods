package Misha.last.service;

import Misha.last.dto.GoodsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    GoodsDto saveGoods(GoodsDto goods) throws Exception;

    void deleteGoods(Integer id);

    GoodsDto findByName(String name);

    List<GoodsDto> findAll();
}
