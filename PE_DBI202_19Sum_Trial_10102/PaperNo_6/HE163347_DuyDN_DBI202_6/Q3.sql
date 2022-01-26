select c.ID,c.CustomerName,
c.Segment,c.Country,c.[State],
c.PostalCode,c.Region
from Customer c 
inner join Orders o 
on c.ID  = o.CustomerID
where c.CustomerName like 'B%'
and month(o.OrderDate) = 12
and Year(o.OrderDate) = 2017
order by c.Segment desc, 
c.CustomerName asc
