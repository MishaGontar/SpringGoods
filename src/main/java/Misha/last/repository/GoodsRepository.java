package Misha.last.repository;

import Misha.last.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods , Integer> {
    Goods findByName(String name);
}
