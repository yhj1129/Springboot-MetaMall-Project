package shop.mtcoding.metamall.model.ordersheet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface OrderSheetRepository extends JpaRepository<OrderSheet, Long> {
    @Query("select o from OrderSheet o where o.user.id = :userId")
    Optional<OrderSheet> findByUserId(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("delete from OrderSheet o where o.user.id = :userId")
    void deleteByUserId(@Param("userId") Long userId);
}
