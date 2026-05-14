package com.msa4spring.controllers;

import com.msa4spring.requests.PostsFilterRequest;
import com.msa4spring.requests.UsersPaginationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    // [FLOW/1-1]: GET-쿼리 파라미터 획득 (2026-05-14, JunHyeon)
    @GetMapping("/users")
    public String index(
            @RequestParam String name
            , @RequestParam(required = false, defaultValue = "none") String nickname
    ) {
        // [NOTE]: 쿼리 파라미터 획득 방법: @RequestParam을 통해 획득 (2026-05-14, JunHyeon)
        return "GET Users: " + "name=" + name + "&" + "nickname=" + nickname;
    }

    // [FLOW/1-2]: GET-세그먼트 파라미터 획득 (2026-05-14, JunHyeon)
    @GetMapping("/users/{id}")
    public String index(@PathVariable String id) {
        return "Get User: " + id;
    }

    @PostMapping("/users")
    public String store() {
        return "POST Users";
    }

    // [FLOW/2-1]: DTO를 통해 쿼리 파라미터 획득 (2026-05-14, JunHyeon)
    @GetMapping("/users/dto-param")
    public String dtoParam(UsersPaginationRequest usersPaginationRequest) {
        return String.format("GET dtoParam: %d, %d"
                , usersPaginationRequest.page(), usersPaginationRequest.limit());
    }

    // [FLOW/2-2]: DTO를 활용한 세그먼트 파라미터 획득 (2026-05-14, JunHyeon)
    // [NOTE]: @ModelAttribute: DTO를 통해서 세그먼트 파라미터, form 데이터를 받을 경우 (2026-05-14, JunHyeon)
    @GetMapping("/posts/{id}/filter/{categoryId}")
    public String postFilter(
            @ModelAttribute PostsFilterRequest postsFilterRequest
    ) {
        return String.format("postFilter: %d, %d"
                , postsFilterRequest.id(), postsFilterRequest.categoryId());
    }

    // [FLOW/3-1]: DTO를 통해 JSON 데이터 획득 (2026-05-14, JunHyeon)
    @GetMapping("/posts/json")
    public String postsJson(
            @RequestBody PostsFilterRequest postsFilterRequest
    ) {
        return String.format("postJson: %d, %d"
                , postsFilterRequest.id(), postsFilterRequest.categoryId());
    }
}
