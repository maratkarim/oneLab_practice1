package kz.onelab.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Long id;
    private String name;
    private String author;
}
