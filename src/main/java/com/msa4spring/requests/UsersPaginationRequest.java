package com.msa4spring.requests;

public record UsersPaginationRequest(
        Integer page
        ,Integer limit
) {
    // [NOTE]: 생성자에 커스텀으로 로직을 세팅해줄 수도 있음 (2026-05-14, JunHyeon)
    public UsersPaginationRequest(Integer page, Integer limit) {
        this.page = (page == null) ? 1 : page;
        this.limit = (limit == null) ? 10 : limit;
    }
}
