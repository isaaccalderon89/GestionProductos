import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.infrastructure.controller.ProductoController;
import com.neoris.gestionproductos.usecases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @Mock
    FindAllProductosUseCase findAllProductosUseCase;
    @Mock
    CreateProductUseCase createProductUseCase;
    @Mock
    UpdateProductUseCase updateProductUseCase;
    @Mock
    DeleteProductUseCase deleteProductUseCase;
    @Mock
    FindByStockUseCase findByStockUseCase;

    @InjectMocks
    ProductoController productoController;

    List<Producto> productos;

    AutoCloseable closeable;

    @BeforeEach
    void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllTest(){
        when(findAllProductosUseCase.findAllProductos()).thenReturn(productos);
        ResponseEntity<List<Producto>> result = productoController.getAllProductos();
        assertEquals(productos,result.getBody());
    }

    @Test
    void createProductTest(){
        Producto producto = new Producto(1,"Pantalones",65,19.99,2017);
        when(createProductUseCase.createProduct(producto)).thenReturn(producto);
        ResponseEntity<Producto> newProducto = productoController.createProducto(producto);
        assertEquals(HttpStatus.CREATED, newProducto.getStatusCode());
        assertEquals(producto, newProducto.getBody());
    }
    @Test
    void updateProductoTest(){
        Producto producto = new Producto(1,"Pantalones",65,19.99,2017);
        when(updateProductUseCase.updateProducto(producto)).thenReturn(producto);
        ResponseEntity<Producto> newProducto = productoController.updateProducto(producto);
        assertEquals(HttpStatus.CREATED, newProducto.getStatusCode());
        assertEquals(producto, newProducto.getBody());
    }
    @Test
    void deleteProductoTest(){
        Integer idProducto = 1;
        when(deleteProductUseCase.deleteProducto(idProducto)).thenReturn(false);
        ResponseEntity<Void> response = productoController.deleteProduct(idProducto);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void findByStockTest(){
        Integer stock = 8;
        List<Producto> productos = new ArrayList<>();
        Producto producto = new Producto();
        producto.setCantidad(stock);
        productos.add(producto);
        when(findByStockUseCase.findByStock(stock)).thenReturn(productos);
        ResponseEntity<List<Producto>> response = productoController.findByCantidad(stock);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productos, response.getBody());
    }

}
