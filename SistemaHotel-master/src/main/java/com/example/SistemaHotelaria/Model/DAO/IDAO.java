package com.example.SistemaHotelaria.Model.DAO;
import java.util.List;

import com.example.SistemaHotelaria.Model.entity.Abstrata;

public interface IDAO<H extends Abstrata> {

    void cadastrar(H entidade);

    void atualizar(H entidade);

    void excluir(int id);

    H buscar(int id);

    List<H> listar();
}
