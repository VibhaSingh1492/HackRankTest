package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private final HashMap<Furniture, Integer> furnitureMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitureMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
       Integer count = 0;
        if(furnitureMap.containsKey(type)){
            count = furnitureMap.get(type);
        }
        furnitureMap.put(type, count+furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return new HashMap<Furniture, Integer>(furnitureMap);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        if(!furnitureMap.isEmpty()){
            return furnitureMap.entrySet().stream().map(f -> f.getKey().cost() * f.getValue()).collect(Collectors.toList()).stream.reduce(Float::sum).get();
        }
        return 0.0f;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if(furnitureMap.containsKey(type)){
            return furnitureMap.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
         if(furnitureMap.containsKey(type)){
            return furnitureMap.get(type) * type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        if(!furnitureMap.isEmpty()){
            return furnitureMap.values().stream.reduce(Integer::sum).get();
        }
        return 0;
    }
}
