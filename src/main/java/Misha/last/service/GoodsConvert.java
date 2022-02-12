package Misha.last.service;

import Misha.last.dto.GoodsDto;
import Misha.last.entity.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsConvert {

    public Goods fromDtoToGood(GoodsDto goodsDto) {
        return Goods.builder()
                .id(goodsDto.getId())
                .name(goodsDto.getName())
                .cost(goodsDto.getCost())
                .build();
    }

    public GoodsDto fromGoodToDto(Goods goods) {
        return GoodsDto.builder()
                .id(goods.getId())
                .name(goods.getName())
                .cost(goods.getCost())
                .build();
    }
}
