package com.example.springsecurity.entity;

public enum MemberRoleEnum {
    USER(Authority.USER), //일반 사용자
    ADMIN(Authority.ADMIN); //관리자

    private final String authority;

    MemberRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_USER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
