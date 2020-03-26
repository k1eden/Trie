package Test;

import com.k1.Trie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class TrieTest {

    @org.junit.jupiter.api.Test
    void find() {
        Trie trie = new Trie();
        assertFalse(trie.find("jsjs"));
        trie.put("Кекс");
        assertFalse(trie.find("s"));
        assertTrue(trie.find("Кекс"));
    }

    @org.junit.jupiter.api.Test
    void put() {
        Trie trie = new Trie();
        trie.put("Челка");
        trie.put("Кепка");
        trie.put("Сорняк");
        trie.put("Лизинг");
        trie.put("Тууа");
        trie.put("Карамель");
        assertTrue(trie.find("Челка"));
        assertTrue(trie.find("Кепка"));
        assertTrue(trie.find("Сорняк"));
        assertTrue(trie.find("Лизинг"));
        assertTrue(trie.find("Тууа"));
        assertTrue(trie.find("Карамель"));
        assertFalse(trie.find("ккррк"));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        Trie trie = new Trie();
        trie.put("литва");
        trie.put("корона");
        trie.put("вирус");
        trie.put("газон");
        trie.put("ритм");
        trie.remove("литва");
        assertFalse(trie.find("литва"));
        assertTrue(trie.find("вирус"));
    }

    @org.junit.jupiter.api.Test
    void findByPrefix() {
        Trie trie = new Trie();
        trie.put("кос");
        trie.put("коса");
        trie.put("косач");
        trie.put("косапий");
        trie.put("негатив");
        trie.put("позитив");
        trie.put("кремний");
        assertEquals(trie.findByPrefix("кос"), List.of("кос", "коса", "косач", "косапий"));;
    }
}