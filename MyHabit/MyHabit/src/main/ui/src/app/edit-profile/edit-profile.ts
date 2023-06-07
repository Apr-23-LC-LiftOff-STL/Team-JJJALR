export interface ProfileEdit {
id: number;
// not sure if user is needed here since we can find user with id
// user: string; 
firstName: string;
lastName: string;
displayName: string;
email: string;
location: string;
status: string;
bio: string;
profileImageURL: string;
habits: Habits[];
habitSettings: HabitSettings[];
}

export interface Habits {
    id: number;
    name: string;
    description: string;
}

export interface HabitSettings {
    id: number;
    active: boolean;
    complete: boolean;
    hidden: boolean;
}