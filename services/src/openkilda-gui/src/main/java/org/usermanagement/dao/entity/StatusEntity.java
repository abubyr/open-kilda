package org.usermanagement.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.openkilda.entity.BaseEntity;

@Entity
@Table(name = "kilda_status")
public class StatusEntity extends BaseEntity {

    @Id
    @Column(name = "status_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer statusId;

    @Column(name = "status_code", nullable = false)
    private String statusCode;

    @Column(name = "status", nullable = false)
    private String status;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(final Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusEntity [statusId=" + statusId + ", statusCode=" + statusCode + ", status=" + status + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StatusEntity other = (StatusEntity) obj;
        if (statusId == null) {
            if (other.statusId != null) {
                return false;
            }
        } else if (!statusId.equals(other.statusId)) {
            return false;
        }
        return true;
    }

}