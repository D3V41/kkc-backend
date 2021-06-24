package com.example.kkcbackend.payload.responce;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class JwtResponce implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private String jwttoken;
    private String userName;
    private String password;
    private Long projectId;
    private String clusterName;
    private List<String> role;

    public JwtResponce(String jwttoken, String userName, String password, Long projectId, String clusterName, List<String> role) {
        this.jwttoken = jwttoken;
        this.userName = userName;
        this.password = password;
        this.projectId = projectId;
        this.clusterName = clusterName;
        this.role = role;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public List<String> getRole() {
        return role;
    }
}
