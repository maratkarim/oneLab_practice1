package kz.onelab.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Library {
    private Long id;
    private String name;
    private List<Book> books;
}
