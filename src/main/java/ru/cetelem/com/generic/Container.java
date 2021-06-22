package ru.cetelem.com.generic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Container <T extends Product & SuperProduct>{

    private T item;

}
