/*
 * Facade.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */

package com.proj.wsf.core.facade.impl;

import com.proj.wsf.core.IFacade;
import com.proj.wsf.core.IServico;
import com.proj.wsf.core.IStrategy;
import com.proj.wsf.core.application.Result;
import com.proj.wsf.model.DomainEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Description the class  Facade - Classe que gerencia a execução de regras e
 * operações de acordo com a entity passada por parametro e o servico desta
 * entity.
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.1 23/01/2019
 */
@Component("facade")
public class Facade implements IFacade {

    private Result resultado;

    /**
     * Contrutor da classe.
     */
    public Facade() {
    }

    /**
     * Método que realiza as regras para a operação salvar para a entity passada
     * por parametro e metodo salvar do repositorio do serviço.
     *
     * @param entity
     * @param servico
     * @return Result
     */
    @Override
    public Result save(DomainEntity entity, IServico servico) {

        resultado = new Result();

        String msg = executarRegras(entity, "SALVAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                servico.getRepository().save(entity);
                List<DomainEntity> entitys = new ArrayList<DomainEntity>();
                entitys.add(entity);
                resultado.setEntity(entitys);
            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;
    }

    /**
     * Método que realiza as regras para a operação alterar para a entity
     * passada por parametro e metodo alterar do repositorio do serviço.
     *
     * @param entity
     * @param servico
     * @return Result
     */
    @Override
    public Result update(DomainEntity entity, IServico servico) {

        resultado = new Result();

        String msg = executarRegras(entity, "ALTERAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                servico.getRepository().update(entity);
                List<DomainEntity> entitys = new ArrayList<DomainEntity>();
                entitys.add(entity);
                resultado.setEntity(entitys);
            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }
        return resultado;
    }

    /**
     * Método que realiza as regras para a operação deletar para a entity
     * passada por parametro e metodo deletar do repositorio do serviço.
     *
     * @param id
     * @param servico
     * @return Result
     */
    @Override
    public Result delete(Long id, IServico servico) {

        resultado = new Result();

        DomainEntity entity = null;
        try {
            entity = (DomainEntity) servico.getClasse().newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            resultado.setMsg("Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
            return resultado;
        }
        String msg = executarRegras(entity, "EXCLUIR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                List<DomainEntity> entitys = servico.getRepository().delete(id);
                if (entitys == null) {
                    resultado.setError();
                    resultado.setMsg("Exclusão não executado, por gentileza verifique seus dados!");
                    return resultado;
                }
                resultado.setMsg("Exclusão realizada com sucesso!");
                resultado.setEntity(entitys);

            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;
    }

     /**
     * Método que realiza as regras para a operação alterar para a entity
     * passada por parametro e metodo alterar do repositorio do serviço.
     *
     * @param entity
     * @param servico
     * @return Result
     */
    @Override
    public Result disable(DomainEntity entity, IServico servico) {

        resultado = new Result();

        String msg = executarRegras(entity, "ALTERAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                servico.getRepository().disable(entity);
                List<DomainEntity> entitys = new ArrayList<DomainEntity>();
                entitys.add(entity);
                resultado.setEntity(entitys);
            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }
        return resultado;
    }

    
    
    
    /**
     * Método que realiza as regras para a operação consultar para a entity
     * passada por parametro e metodo consultar todos do repositorio do serviço.
     *
     * @param classe
     * @param servico
     * @return Result
     */
    @Override
    public Result findAll(Class classe, IServico servico) {

        resultado = new Result();
        DomainEntity entity = null;
        try {
            entity = (DomainEntity) servico.getClasse().newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            resultado.setMsg("Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
            return resultado;
        }

        String msg = executarRegras(entity, "CONSULTAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                List<DomainEntity> findAll = servico.getRepository().findAll();
                if (findAll == null) {
                    resultado.setMsg("Busca não encontrada, por favor verifique as dados digitados!");
                    return resultado;
                }
                resultado.setEntity(findAll);

            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;

    }

    /**
     * Método que realiza as regras para a operação consultar para a entity
     * passada por parametro e metodo consultar por id do repositorio do
     * serviço.
     *
     * @param id
     * @param servico
     * @return Result
     */
    @Override
    public Result findById(Long id, IServico servico) {
        resultado = new Result();

        DomainEntity entity = null;
        try {
            entity = (DomainEntity) servico.getClasse().newInstance();
        } catch (IllegalAccessException | InstantiationException ex) {
            resultado.setMsg("Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
            return resultado;
        }
        String msg = executarRegras(entity, "CONSULTAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                List<DomainEntity> entitys = servico.getRepository().findById(id);
                if (entitys == null) {
                    resultado.setMsg("Busca não encontrada, por favor verifique as dados digitados!");
                    return resultado;
                }
                resultado.setEntity(entitys);

            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;

    }

    /**
     * Método que realiza as regras para a operação consultar para a entity
     * passada por parametro e metodo consultar por filtro do repositorio do
     * serviço.
     *
     * @param entity
     * @param servico
     * @return Result
     */
    @Override
    public Result FindByFilter(DomainEntity entity, IServico servico) {
        resultado = new Result();

        String msg = executarRegras(entity, "CONSULTAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            try {
                Iterable<DomainEntity> findAll = servico.getRepository().findByFilter(entity);
                if (findAll == null) {
                    resultado.setMsg("Busca não encontrada, por favor verifique as dados digitados!");
                    return resultado;
                }
                resultado.setEntity(findAll);

            } catch (Exception e) {
                resultado.setError();
                resultado.setMsg("Exception: " + e.toString() + " Message: " + e.getMessage());
            }
        }

        return resultado;
    }

    /**
     * Método que realiza as regras para a operação visualizar para a entity
     * passada por parametro.
     *
     * @param servico
     * @return Result
     */
    @Override
    public Result view(DomainEntity entity, IServico servico) {
        resultado = new Result();
        String msg = executarRegras(entity, "VISUALIZAR", servico.getStrategys());

        if (msg != null) {
            resultado.setError();
            resultado.setMsg(msg);
        } else {
            List<DomainEntity> list = new ArrayList<DomainEntity>();
            list.add(entity);
            resultado.setEntity(list);
        }
        return resultado;

    }

    /**
     * Método que executa as regras de acordo com a ação e entidade.
     *
     * @param entity
     * @param action
     * @param roles
     * @return String
     */
    private String executarRegras(DomainEntity entity, String action, Map<String, List<IStrategy>> roles) {

        StringBuilder msg = new StringBuilder();

        if (roles != null) {
            List<IStrategy> regras = roles.get(action);

            if (regras != null) {
                for (IStrategy s : regras) {

                    String m = s.process(entity);
                    if (m != null) {
                        // throw new RuntimeException("Não foi possivel realizar operação. Mensagem: " + m);
                        msg.append(m).append("\n");
                        break;
                    }
                }
            }
        }

        if (msg.length() > 0) {
            return msg.toString();
        } else {
            return null;
        }
    }

}

