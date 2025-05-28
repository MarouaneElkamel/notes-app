import dayjs from 'dayjs';
import { ITag } from 'app/shared/model/tag.model';

export interface INote {
  id?: number;
  title?: string;
  content?: string | null;
  createdAt?: dayjs.Dayjs | null;
  lastModifiedAt?: dayjs.Dayjs | null;
  tags?: ITag[] | null;
}

export const defaultValue: Readonly<INote> = {};
