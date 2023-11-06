package com.servico.backservico.service;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private ServicoRepository servicoRepository;
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    // SERVIÇO PARA LISTAR TODOS
    public List<Servico> buscarTodos(){
        return servicoRepository.findAll();
    }

    // FAZ UMA COSULTA PERSONALIZADA DO BANCO DE DADOS NA INTERFACE REPOSITORY
    public List<Servico> buscarServicosPagamentoPendente(){
        return servicoRepository.buscarServicosPagamentoPendente();
    }
    // FAZ UMA COSULTA PERSONALIZADA DO BANCO DE DADOS NA INTERFACE REPOSITORY
    public List<Servico> buscarServicosCancelados(){
        return servicoRepository.buscarServicosCancelados();
    }

    // SERVIÇO PARA INSERIR NO BANCO

    /*Por padrão, quando um serviço for cadastrado sem o valor pago e a data de pagamento,
    seu status será definido como automaticamente como "pendente". Ao concluir o valor pago e a
    data de pagamento, defini-lo como "realizado".*/

    public Servico inserir(Servico servico){
        //return servicoRepository.save(servico);
        if(servico.getValorPago() == null || servico.getValorPago() == 0 || servico.getDataPagameto() == null) {
            servico.setStatus("pendente");
        }else{
            servico.setStatus("realizado");
        }
        Servico servicoBanco = servicoRepository.saveAndFlush(servico);
        return servicoBanco;
    }

    public Servico alterar(Servico servico){
        if(servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDataPagameto() != null) {
            servico.setStatus("realizado");
        }
        return servicoRepository.saveAndFlush(servico);
    }
    public void cancelarServico(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servico.setStatus("cancelado");
        servicoRepository.save(servico);
    }

    // para eu pegar um dado de um Optional é usado o get()
    public void excluir(Long id){
        Servico servico = servicoRepository.findById(id).get();
        servicoRepository.delete(servico);

    }

}
