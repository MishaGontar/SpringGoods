package Misha.last.service;

import Misha.last.dto.GoodsDto;
import Misha.last.entity.Goods;
import Misha.last.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsServiceDefault implements GoodsService {
    @Autowired
    private final GoodsRepository repository;
    @Autowired
    private final GoodsConvert convert;

    @Override
    public GoodsDto saveGoods(GoodsDto goods) throws Exception {
        Goods goods1 = repository.save(convert.fromDtoToGood(goods));
        return convert.fromGoodToDto(goods1);
    }

    @Override
    public void deleteGoods(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public GoodsDto findByName(String name) {
        Goods goods = repository.findByName(name);
        if (goods != null) return convert.fromGoodToDto(goods);
        return null;
    }

    @Override
    public List<GoodsDto> findAll() {
        return repository.findAll()
                .stream()
                .map(convert::fromGoodToDto)
                .collect(Collectors.toList());
    }
}
