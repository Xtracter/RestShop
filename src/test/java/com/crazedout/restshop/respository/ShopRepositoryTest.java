package com.crazedout.restshop.respository;

import com.crazedout.restshop.model.ShopModel;
import com.crazedout.restshop.repository.RESTRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ShopRepositoryTest {

    @Autowired
    private RESTRepository repo;

    @Test
    @DisplayName("save and find restshop")
    void saveAndFind() {

        ShopModel t = new ShopModel("Test", "desc");
        ShopModel saved = repo.save(t);

        assertThat(saved.getId()).isNotNull();

        List<ShopModel> all = repo.findAll();
        assertThat(all).isNotEmpty();
        assertThat(all).extracting(ShopModel::getTitle).contains("Test");

    }
}
