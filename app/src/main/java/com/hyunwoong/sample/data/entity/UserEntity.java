package com.hyunwoong.sample.data.entity;

import com.hyunwoong.sample.base.component.BaseEntity;
import lombok.*;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:13
 * @homepage : https://github.com/gusdnd852
 */
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {
    private String id;
    private String pw;
}
