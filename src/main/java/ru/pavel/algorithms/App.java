package ru.pavel.algorithms;

import java.util.Random;

/**
 * 1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 * Необходимые определения:
 ** 1.Высота данного узла - максимальная длина нисходящего пути от этого узла к самому нижнему листу.
 ** 2.Высота дерева - это высота корня.Высота дерева состоящего из одного корня равно 0.Высоту пустого дерева будем тоже считать равной 0.
 ** 3.Сбалансированное по высоте дерево - это дерево для каждой вершины которого высота её двух поддеревьев различается не более чем на 1.
 * Пустое дерево будем считать сбалансированным.
 *
 * 4.
 * Алгоритм действий:
 * 1.Добавить поле height, которое хранит высоту данного узла. При вставке и удалении узла обновлять это поле так же, как и size. ###
 * 2.Изменить конструктор Node. При создании нового узла в методе put, указывать высоту 0.
 * 3.Добавить аналогично полю size, открытый и закрытый методы height().
 * 4.Сбалансированность дерева определяем с помощью метода isBalanced(). Этод метод рекурсивно проверяет сбалансированность всех узлов.
 */
public class App 
{
    public static void main( String[] args )
    {
        int balanced = 0;
        int unbalanced = 0;

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            MyTreeMap myTreeMap = new MyTreeMap();
            while (myTreeMap.height() < 7) {
                myTreeMap.put(random.nextInt(201) - 100, 0);
                if (myTreeMap.isBalanced()) {
                    balanced++;
                } else {
                    unbalanced++;
                }
            }
        }

        System.out.println("balanced " + balanced);
        System.out.println("unbalanced " + unbalanced);
        System.out.println("percentage of unbalanced is " + ((float) unbalanced) * 100 / (unbalanced + balanced) + "%");
    }
}
