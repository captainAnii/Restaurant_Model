import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("/{name}")
    public Optional<Restaurant> getRestaurantByName(@PathVariable String name) {
        return restaurantRepository.findByName(name);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants(@RequestParam(required = false) String name) {
        if (name == null) {
            return restaurantRepository.findAll();
        } else {
            return restaurantRepository.findByNameContaining(name);
        }
    }
}