package com.mina.book.springboot.service.posts;

import com.mina.book.springboot.domain.posts.Posts;
import com.mina.book.springboot.domain.posts.PostsRepository;
import com.mina.book.springboot.web.dto.PostsResponseDto;
import com.mina.book.springboot.web.dto.PostsSaveRequestDto;
import com.mina.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor        // @Autowired 대신 생성자를 주입받는 방식. final이 선언된 모든 필드의 생성자 생성 -> 유지보수 용이
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {     // 더티체킹: entity 값 변경으로, update 쿼리 필요 없음
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    public List<Posts> findAll() {

        List<Posts> postsList = postsRepository.findAll();

        return postsList;
    }
}