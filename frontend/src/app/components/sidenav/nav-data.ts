import { INavbarData } from "./helper";

export function getNavbarData(): INavbarData[] {

  const navbarData: INavbarData[] = [
    {
      routeLink: 'home',
      icon: 'fas fa-home',
      label: 'Home'
    },
    {
      routeLink: 'products',
      icon: 'fal fa-box-full',
      label: 'Products'
    },
    {
      routeLink: 'categories',
      icon: 'fal fa-tag',
      label: 'Categories',
      items: [
        {
          routeLink: 'categories/Electronics',
          label: 'Electronics'
        },
        {
          routeLink: 'categories/Smartphones & Tablets',
          label: 'Smartphones & Tablets'
        },
        {
          routeLink: 'categories/Computers & Laptops',
          label: 'Computers & Laptops'
        },
        {
          routeLink: 'categories/Televisions',
          label: 'Televisions'
        },
        {
          routeLink: 'categories/Gaming',
          label: 'Gaming'
        },
        {
          routeLink: 'categories/Fashion & Accessories',
          label: 'Fashion & Accessories'
        },
        {
          routeLink: 'categories/Home',
          label: 'Home'
        },
        {
          routeLink: 'categories/Movies & Books',
          label: 'Movies & Books'
        },
        {
          routeLink: 'categories/Sports & Outdoors',
          label: 'Sports & Outdoors'
        },
        {
          routeLink: 'categories/Food',
          label: 'Food'
        }
      ]
    },
    {
      routeLink: 'superchollos-view',
      icon: 'fal fa-fire',
      label: 'Superchollos'
    }
  ];

  return navbarData;
}

export var navbarData: INavbarData[] = getNavbarData();
