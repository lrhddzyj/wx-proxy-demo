package com.mind.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by serv on 2015/5/14.
 */
public class DeviceApplyId implements Serializable {

    @JsonProperty("apply_id")
    private String applyId;

    @JsonProperty("device_identifiers")
    private List<Identifiers> identifierses;

    @JsonProperty("audit_status")
    private String auditStatus;

    @JsonProperty("audit_comment")
    private String auditComment;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public List<Identifiers> getIdentifierses() {
        return identifierses;
    }

    public void setIdentifierses(List<Identifiers> identifierses) {
        this.identifierses = identifierses;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }
}
