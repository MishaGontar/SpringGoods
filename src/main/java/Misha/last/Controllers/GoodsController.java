package Misha.last.Controllers;

import Misha.last.dto.GoodsDto;
import Misha.last.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
@AllArgsConstructor
public class GoodsController {
    @Autowired
    private final GoodsService goodsService;

    @ResponseBody
    @PostMapping(value = "/saveGo")
    public GoodsDto saveGoods(@RequestBody GoodsDto goodsDto) throws Exception {
        return goodsService.saveGoods(goodsDto);
    }

    @GetMapping(value = "/findAll")
    public List<GoodsDto> findAll() {
        return goodsService.findAll();
    }

    @GetMapping(value = "/findByName")
    public GoodsDto findByName(@RequestParam String name) {
        return goodsService.findByName(name);
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteGoodsById(@PathVariable Integer id) {
        goodsService.deleteGoods(id);
        return "redirect:/goods/findAll";
    }
}
