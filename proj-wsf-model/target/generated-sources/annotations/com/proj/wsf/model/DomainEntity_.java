package com.proj.wsf.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DomainEntity.class)
public abstract class DomainEntity_ {

	public static volatile SingularAttribute<DomainEntity, Date> changedIn;
	public static volatile SingularAttribute<DomainEntity, Date> includedIn;
	public static volatile SingularAttribute<DomainEntity, String> changedBy;
	public static volatile SingularAttribute<DomainEntity, String> includedBy;
	public static volatile SingularAttribute<DomainEntity, String> active;
	public static volatile SingularAttribute<DomainEntity, String> user;

	public static final String CHANGED_IN = "changedIn";
	public static final String INCLUDED_IN = "includedIn";
	public static final String CHANGED_BY = "changedBy";
	public static final String INCLUDED_BY = "includedBy";
	public static final String ACTIVE = "active";
	public static final String USER = "user";

}

