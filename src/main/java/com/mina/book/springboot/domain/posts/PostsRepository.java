package com.mina.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Entity Class와 Entity Repository는 함께 위치해야 함

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
