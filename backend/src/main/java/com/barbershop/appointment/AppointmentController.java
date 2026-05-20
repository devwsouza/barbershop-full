
package com.barbershop.appointment;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private List<Map<String, Object>> db = new ArrayList<>();

    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> data) {
        data.put("id", UUID.randomUUID().toString());
        db.add(data);
        return data;
    }

    @GetMapping
    public List<Map<String, Object>> list() {
        return db;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        db.removeIf(a -> a.get("id").equals(id));
    }
}
