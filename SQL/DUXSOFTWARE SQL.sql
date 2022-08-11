/*
1 Todos los productos del rubro "librería", creados hoy.
*/
SELECT * FROM producto
WHERE id_rubro = (
SELECT id_rubro 
FROM rubro WHERE rubro = "libreria") AND fecha_creacion = current_date();
/*
2 Monto total vendido por cliente (mostrar nombre del cliente y monto).
*/
SELECT SUM(precio*cantidad) AS TotalVendido , nombre 
FROM venta 
group by nombre;
/*
3 Cantidad de ventas por producto.
*/ 
SELECT COUNT(*) AS Cantidad , 
(SELECT nombre FROM producto WHERE codigo = codigo_producto) AS NombreProducto 
FROM venta
group by codigo_producto ;
/*
4 Cantidad de productos comprados por cliente en el mes actual.
*/
SELECT COUNT(*) AS CantidadVendida , nombre AS fecha
FROM venta
WHERE month(fecha)= month(current_date())
GROUP BY id_cliente;
/*
5  Ventas que tienen al menos un producto del rubro "bazar".
*/
SELECT COUNT(*) AS VentasBazar 
FROM venta AS v
INNER JOIN producto AS p ON p.codigo = v.codigo_producto
INNER JOIN rubro AS r ON r.id_rubro = p.id_rubro 
WHERE r.rubro = 'bazar' ; 
/*
6 Rubros que no tienen ventas en los últimos 2 meses.
*/
SELECT r.rubro 
FROM rubro AS r 
INNER JOIN producto AS p ON p.id_rubro = r.id_rubro
INNER JOIN venta AS v ON v.codigo_producto = p.codigo
WHERE MONTH(fecha) < (MONTH(current_date()) - 2) 
GROUP BY r.rubro;