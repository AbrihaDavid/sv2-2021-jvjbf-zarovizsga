package shipping;

import java.util.*;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable pack){
        packages.add(pack);
    }

    public List<Transportable> getPackages() {
        return packages;
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        return packages.stream()
                .filter(b-> b.isBreakable() == breakable)
                .filter(w-> w.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry(){

        Map<String,Integer> result = new HashMap<>();
        for (Transportable t: packages){
            if (!result.containsKey(t.getDestinationCountry())){
                result.put(t.getDestinationCountry(), 1);
            } else {
                result.put(t.getDestinationCountry(),result.get(t.getDestinationCountry()) +1 );
            }
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance(){
        return packages.stream()
                .filter(i -> i instanceof InternationalPackage)
                .sorted(Comparator.comparing(p-> ((InternationalPackage)p).getDistance()))
                .toList();
    }
}
