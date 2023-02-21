package supportingSalesApp.service;

import org.springframework.stereotype.Service;
import supportingSalesApp.model.AppUser;
import supportingSalesApp.model.Ord;
import supportingSalesApp.repo.OrdRepo;

import java.util.List;

@Service
public class OrdService {
    private OrdRepo ordRepo;

    public OrdService(OrdRepo ordRepo) {
        this.ordRepo = ordRepo;
    }

    public void addOrd(Ord ord) {
        ord.setProductName(ord.getProductName());
        ord.setPrice(ord.getPrice());
        ord.setQuantity(ord.getQuantity());
        ord.setPaid(ord.isPaid());
        ordRepo.save(ord);
    }

    public List<Ord> showOrders() {
        return ordRepo.findAll();
    }

    public List<Ord> showUserOrders(AppUser appUser) {
        return ordRepo.findByAppUser(appUser);
    }
}
