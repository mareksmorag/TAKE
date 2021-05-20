using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

#nullable disable

namespace CompanyApi.Models
{
    [Table("department")]
    public partial class Department
    {
        public Department()
        {
            Employees = new HashSet<Employee>();
        }

        [Key]
        [Column(TypeName = "int(11)")]
        public int DepartmentId { get; set; }
        [StringLength(20)]
        public string Name { get; set; }

        [InverseProperty(nameof(Employee.Department))]
        public virtual ICollection<Employee> Employees { get; set; }
    }
}
