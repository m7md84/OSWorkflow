/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
/*
 * Generated by XDoclet - Do not edit!
 */
package com.opensymphony.workflow.spi.ejb;


/**
 * CMP layer for HistoryStep.
 * @author <a href="mailto:hani@formicary.net">Hani Suleiman</a>
 * @author <a href="mailto:plightbo@hotmail.com">Pat Lightbody</a>
 */
public abstract class HistoryStepCMP extends com.opensymphony.workflow.spi.ejb.HistoryStepEJB implements javax.ejb.EntityBean {
    //~ Methods ////////////////////////////////////////////////////////////////

    public abstract void setActionId(int actionId);

    public abstract int getActionId();

    public abstract void setCaller(java.lang.String caller);

    public abstract java.lang.String getCaller();

    public abstract void setDueDate(java.sql.Timestamp dueDate);

    public abstract java.sql.Timestamp getDueDate();

    public abstract void setEntryId(long entryId);

    public abstract long getEntryId();

    public abstract void setFinishDate(java.sql.Timestamp finishDate);

    public abstract java.sql.Timestamp getFinishDate();

    public abstract void setId(java.lang.Long id);

    public abstract java.lang.Long getId();

    public abstract void setOwner(java.lang.String owner);

    public abstract java.lang.String getOwner();

    public abstract void setStartDate(java.sql.Timestamp startDate);

    public abstract java.sql.Timestamp getStartDate();

    public abstract void setStatus(java.lang.String status);

    public abstract java.lang.String getStatus();

    public abstract void setStepId(int stepId);

    public abstract int getStepId();

    public void setEntityContext(javax.ejb.EntityContext ctx) {
    }

    public void ejbActivate() {
    }

    public void ejbLoad() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() throws javax.ejb.RemoveException {
    }

    public void ejbStore() {
    }

    public void unsetEntityContext() {
    }
}
