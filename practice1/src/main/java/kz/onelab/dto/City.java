package kz.onelab.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {
    private Long id;
    private String name;
    private List<Library> libraries;
}
