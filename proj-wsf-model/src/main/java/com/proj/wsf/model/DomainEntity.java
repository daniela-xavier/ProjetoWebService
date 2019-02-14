/*
 * DomainEntity.java
 *
 * Created on 23-01-2019
 *
 * Copyright(c) 2019 Foz Sociedade de Advogados.
 
 *
 */
package com.proj.wsf.model;

import com.google.gson.annotations.Expose;
import com.proj.wsf.model.anotations.ActivePattern;
import com.proj.wsf.model.interfaces.OnSave;
import com.proj.wsf.model.interfaces.OnUpdate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Description the class DomainEntity - Classe de objeto real DomainEntity.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 23/01/2019
 */
@MappedSuperclass
public class DomainEntity implements IEntity, Serializable {

    private static final long serialVersionUID = -5377726703339445533L;

    @Expose
    @Column(name = "INCLUIDO_EM")
    @NotNull(message = "Item incluido em inválido", groups = {OnSave.class})
    @Temporal(TemporalType.TIMESTAMP)
    private Date includedIn;

    @Expose
    @Column(name = "ALTERADO_EM")
    @NotNull(message = "Item alterado em inválido", groups = {OnUpdate.class})
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedIn;

    @Expose
    @NotEmpty(message = "Item incluido por inválido", groups = {OnSave.class})
    @Column(name = "INCLUIDO_POR")
    private String includedBy;

    @Expose
    @Column(name = "ALTERADO_POR")
    @NotEmpty(message = "Item alterado por inválido", groups = {OnUpdate.class})
    private String changedBy;

    @Expose
    @NotNull(message = "Item ativo inválido", groups = {OnSave.class})
    @NotEmpty(message = "Item ativo não pode estar em branco", groups = {OnSave.class})
    @ActivePattern(message = "Item ativo deve ser Sim(s) ou Não(n)", groups = {OnSave.class, OnUpdate.class})
    @Column(name = "ATIVO")
    private String active;

    @Transient
    @Expose
    private String tk;

    @Transient
    @Expose
    private String user;

    /**
     * Método para retorno de data de inclusão.
     *
     * @return includedIn
     */
    public Date getIncludedIn() {
        return includedIn;
    }

    /**
     * Método para inserção de data de inclusão.
     *
     * @param includedIn - Data de inclusão
     */
    public void setIncludedIn(Date includedIn) {
        this.includedIn = includedIn;
    }

    /**
     * Método para retorno de active (S - sim ou N - não).
     *
     * @return active
     */
    public String getActive() {
        return active;
    }

    /**
     * Método para inserção de active (S - sim ou N - não).
     *
     * @param active - Ativo ou não
     */
    public void setActive(String active) {
        this.active = active;
    }

    /**
     * Método para retorno de data de alteração.
     *
     * @return changedIn
     */
    public Date getChangedIn() {
        return changedIn;
    }

    /**
     * Método para insercao de data de alteração.
     *
     * @param changedIn - Data de alteração
     */
    public void setChangedIn(Date changedIn) {
        this.changedIn = changedIn;
    }

    /**
     * Método para retorno de data de inclusão.
     *
     * @return includedBy
     */
    public String getIncludedBy() {
        return includedBy;
    }

    /**
     * Método para inserção de autor da inclusão.
     *
     * @param includedBy - Incluido por usuario.
     */
    public void setIncludedBy(String includedBy) {
        this.includedBy = includedBy;
    }

    /**
     * Método para retorno de autor da alteração.
     *
     * @return changedBy - Alterado por usuario.
     */
    public String getChangedBy() {
        return changedBy;
    }

    /**
     * Método para inserção de autor da alteração.
     *
     * @param changedBy - Alterado por usuário
     */
    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    /**
     * Método para inserção do tk.
     *
     * @param tk - Parametro de token.
     */
    public void setTk(String tk) {
        this.tk = tk;
    }

    /**
     * Método para inserção do user.
     *
     * @param user - Parametro de user da requisição.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     * Inclui o ativo = n, para desativar a entidade.
     */
    public void desativarDomainEntity() {
        this.setActive("n");
    }

}
