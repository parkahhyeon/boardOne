package com.study.boardOne.service;

import com.study.boardOne.domin.User;
import com.study.boardOne.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserMapper userMapper;
//        private final PasswordEncoder passwordEncoder;

        /**
         * 회원 정보 저장 (회원가입)
         * @param params - 회원 정보
         * @return PK
         */
        @Transactional
        public Long saveMember(final User params) {
//            params.encodingPassword(passwordEncoder);
            userMapper.save(params);
            return params.getId();
        }

        /**
         * 회원 상세정보 조회
         * @param loginId - UK
         * @return 회원 상세정보
         */
        public User findMemberByLoginId(final String loginId) {
            return userMapper.findByLoginId(loginId);
        }

        /**
         * 회원 정보 수정
         * @param params - 회원 정보
         * @return PK
         */
        @Transactional
        public Long updateMember(final User params) {
//            params.encodingPassword(passwordEncoder);
            userMapper.update(params);
            return params.getId();
        }

        /**
         * 회원 정보 삭제 (회원 탈퇴)
         * @param id - PK
         * @return PK
         */
        @Transactional
        public Long deleteMemberById(final Long id) {
            userMapper.deleteById(id);
            return id;
        }


        /**
         * 회원 수 카운팅 (ID 중복 체크)
         * @param loginId - UK
         * @return 회원 수
         */
        public int countMemberByLoginId(final String loginId) {
            return userMapper.countByLoginId(loginId);
        }

    /**
     * 로그인
     * @param loginId - 로그인 ID
     * @param password - 비밀번호
     * @return 회원 상세정보
     */
    public User login(final String loginId, final String password) {

        // 1. 회원 정보 및 비밀번호 조회
        User member = findMemberByLoginId(loginId);
        String encodedPassword = (member == null) ? "" : member.getPassword();

        // 2. 회원 정보 및 비밀번호 체크
//        if (member == null || passwordEncoder.matches(password, encodedPassword) == false) {
//            return null;
//        }

        // 3. 회원 응답 객체에서 비밀번호를 제거한 후 회원 정보 리턴
        member.clearPassword();
        return member;
    }

    }