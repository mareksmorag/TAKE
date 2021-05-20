using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

#nullable disable

namespace CompanyApi.Models
{
    public partial class CompanyDbContext : DbContext
    {
        public CompanyDbContext()
        {
        }

        public CompanyDbContext(DbContextOptions<CompanyDbContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Department> Departments { get; set; }
        public virtual DbSet<Employee> Employees { get; set; }
        

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.HasCharSet("utf8mb4")
                .UseCollation("utf8mb4_general_ci");

            modelBuilder.Entity<Employee>(entity =>
            {
                entity.Property(e => e.Bonus).HasPrecision(6, 2);

                entity.Property(e => e.Salary).HasPrecision(6, 2);

                entity.HasOne(d => d.Department)
                    .WithMany(p => p.Employees)
                    .HasForeignKey(d => d.DepartmentId)
                    .HasConstraintName("employee_ibfk_2");

                entity.HasOne(d => d.Manager)
                    .WithMany(p => p.Subordinate)
                    .HasForeignKey(d => d.ManagerId)
                    .HasConstraintName("employee_ibfk_1");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
